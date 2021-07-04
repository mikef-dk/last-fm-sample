package com.mikef.lastfm.shared.flipper

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.crashreporter.CrashReporterPlugin
import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import okhttp3.Interceptor

class FlipperConfigImpl : FlipperConfig {

    private val networkPlugin = NetworkFlipperPlugin()

    override fun init(application: Application) {
        if (FlipperUtils.shouldEnableFlipper(application)) {
            SoLoader.init(application, false)

            AndroidFlipperClient.getInstance(application).apply {
                // Crash Reporter
                addPlugin(CrashReporterPlugin.getInstance())

                // Network
                addPlugin(networkPlugin)

                // Database plugin
                addPlugin(DatabasesFlipperPlugin(application))

                // Layout inspector
                val descriptorMapping = DescriptorMapping.withDefaults()
                addPlugin(InspectorFlipperPlugin(application, descriptorMapping))
            }.start()
        }
    }

    override fun getInterceptor(): Interceptor {
        return FlipperOkhttpInterceptor(networkPlugin)
    }

}