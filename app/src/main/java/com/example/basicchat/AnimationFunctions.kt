package com.example.basicchat

import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.`object`.actuation.Animate
import com.aldebaran.qi.sdk.builder.AnimateBuilder
import com.aldebaran.qi.sdk.builder.AnimationBuilder

fun raiseLeftHand(qiContext: QiContext) {
    val helloAnim: com.aldebaran.qi.sdk.`object`.actuation.Animation? = AnimationBuilder.with(qiContext) // Create the builder with the context.
        .withResources(R.raw.raise_left_hand_b006)                    // Set the animation resource.
        .build()                                            // Build the animation.
    // Create an animate action.
    val helloAnimate: Animate = AnimateBuilder.with(qiContext)  // Create the builder with the context.
        .withAnimation(helloAnim)                           // Set the animation.
        .build()                                            // Build the animate action.
    helloAnimate.run()
}