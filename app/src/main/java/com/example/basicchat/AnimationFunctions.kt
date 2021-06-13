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
fun nicereaction(qiContext: QiContext) {
    val niceAnim: com.aldebaran.qi.sdk.`object`.actuation.Animation? =
        AnimationBuilder.with(qiContext) // Create the builder with the context.
            .withResources(R.raw.nicereaction_a002)                    // Set the animation resource.
            .build()                                            // Build the animation.
    // Create an animate action.
    val niceAnimate: Animate =
        AnimateBuilder.with(qiContext)  // Create the builder with the context.
            .withAnimation(niceAnim)                           // Set the animation.
            .build()                                            // Build the animate action.
    niceAnimate.run()
}
fun thinkingreaction(qiContext: QiContext) {
    val thinkAnim: com.aldebaran.qi.sdk.`object`.actuation.Animation? =
        AnimationBuilder.with(qiContext) // Create the builder with the context.
            .withResources(R.raw.thinking_a001)                    // Set the animation resource.
            .build()                                            // Build the animation.
    // Create an animate action.
    val thinkAnimate: Animate =
        AnimateBuilder.with(qiContext)  // Create the builder with the context.
            .withAnimation(thinkAnim)                           // Set the animation.
            .build()                                            // Build the animate action.
    thinkAnimate.run()
}
fun discoreaction(qiContext: QiContext) {
    val discoAnim: com.aldebaran.qi.sdk.`object`.actuation.Animation? =
        AnimationBuilder.with(qiContext) // Create the builder with the context.
            .withResources(R.raw.disco_a001)                    // Set the animation resource.
            .build()                                            // Build the animation.
    // Create an animate action.
    val discoAnimate: Animate =
        AnimateBuilder.with(qiContext)  // Create the builder with the context.
            .withAnimation(discoAnim)                           // Set the animation.
            .build()                                            // Build the animate action.
    discoAnimate.run()
}
fun taichireaction(qiContext: QiContext) {
    val taichiAnim: com.aldebaran.qi.sdk.`object`.actuation.Animation? =
        AnimationBuilder.with(qiContext) // Create the builder with the context.
            .withResources(R.raw.taichichuan_a001)                    // Set the animation resource.
            .build()                                            // Build the animation.
    // Create an animate action.
    val taichiAnimate: Animate =
        AnimateBuilder.with(qiContext)  // Create the builder with the context.
            .withAnimation(taichiAnim)                           // Set the animation.
            .build()                                            // Build the animate action.
    taichiAnimate.run()
}
fun dancereaction(qiContext: QiContext) {
    val danceAnim: com.aldebaran.qi.sdk.`object`.actuation.Animation? =
        AnimationBuilder.with(qiContext) // Create the builder with the context.
            .withResources(R.raw.dance_b005)                    // Set the animation resource.
            .build()                                            // Build the animation.
    // Create an animate action.
    val danceAnimate: Animate =
        AnimateBuilder.with(qiContext)  // Create the builder with the context.
            .withAnimation(danceAnim)                           // Set the animation.
            .build()                                            // Build the animate action.
    danceAnimate.run()
}
fun sadreaction(qiContext: QiContext) {
    val sadAnim: com.aldebaran.qi.sdk.`object`.actuation.Animation? =
        AnimationBuilder.with(qiContext) // Create the builder with the context.
            .withResources(R.raw.sad_a001)                    // Set the animation resource.
            .build()                                            // Build the animation.
    // Create an animate action.
    val sadAnimate: Animate =
        AnimateBuilder.with(qiContext)  // Create the builder with the context.
            .withAnimation(sadAnim)                           // Set the animation.
            .build()                                            // Build the animate action.
    sadAnimate.run()
}