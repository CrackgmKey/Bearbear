package com.lingjuan.app.utils;

/**
 * @author: TaoHui
 * @date: 2019/2/19
 */

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.squareup.picasso.Downloader;
import com.squareup.picasso.NetworkPolicy;

import java.io.File;
import java.io.IOException;

import butterknife.internal.Utils;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public final class OkHttp3Downloader implements Downloader {
    private final Call.Factory client;
    private final Cache cache;
    private boolean sharedClient = true;




    /**
     * Create new downloader that uses OkHttp. This will install an image cache into the specified
     * directory.
     *
     * @param cacheDir The directory in which the cache should be stored
     * @param maxSize The size limit for the cache.
     */
    public OkHttp3Downloader(final File cacheDir, final long maxSize) {
        this(new OkHttpClient.Builder().cache(new Cache(cacheDir, maxSize)).build());
        sharedClient = false;
    }

    /**
     * Create a new downloader that uses the specified OkHttp instance. A response cache will not be
     * automatically configured.
     */
    public OkHttp3Downloader(OkHttpClient client) {
        this.client = client;
        this.cache = client.cache();
    }

    /** Create a new downloader that uses the specified {@link Call.Factory} instance. */
    public OkHttp3Downloader(Call.Factory client) {
        this.client = client;
        this.cache = null;
    }

    @VisibleForTesting Cache getCache() {
        return ((OkHttpClient) client).cache();
    }

    @Override public Response load(@NonNull Uri uri, int networkPolicy) throws IOException {
        CacheControl cacheControl = null;
        if (networkPolicy != 0) {
            if (NetworkPolicy.isOfflineOnly(networkPolicy)) {
                cacheControl = CacheControl.FORCE_CACHE;
            } else {
                CacheControl.Builder builder = new CacheControl.Builder();
                if (!NetworkPolicy.shouldReadFromDiskCache(networkPolicy)) {
                    builder.noCache();
                }
                if (!NetworkPolicy.shouldWriteToDiskCache(networkPolicy)) {
                    builder.noStore();
                }
                cacheControl = builder.build();
            }
        }

        Request.Builder builder = new okhttp3.Request.Builder().url(uri.toString());
        if (cacheControl != null) {
            builder.cacheControl(cacheControl);
        }

        okhttp3.Response response = client.newCall(builder.build()).execute();
        int responseCode = response.code();
        if (responseCode >= 300) {
            response.body().close();
            throw new ResponseException(responseCode + " " + response.message(), networkPolicy,
                    responseCode);
        }

        boolean fromCache = response.cacheResponse() != null;

        ResponseBody responseBody = response.body();
        return new Response(responseBody.byteStream(), fromCache, responseBody.contentLength());
    }

    @Override public void shutdown() {
        if (!sharedClient) {
            if (cache != null) {
                try {
                    cache.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}

