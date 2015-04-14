Main Application for Minecraft Server
=====================

This project is the startup shell for starting CanaryMod and including the plugins in this repository.
More information about CanaryMod can be found at [CanaryMod].


Creating a Distribution
---------------

This project makes use of the Gradle Application plugin to build a distribution and start scripts.  To create a local installation, run `gradlew install`.  To create a zip distribution of the server and plugins, run `gradlew distZip`.

The Minecraft Server EULA
-------------

Minecraft requires you to agree to their EULA before the server will run.  To agree to the EULA (found [here](https://account.mojang.com/documents/minecraft_eula)), copy gradle.properties.sample to gradle.properties and set `eulaAgree=true`.

Adding Plugins
------------

To add a plugin, do the following:

1. Create the plugin project in the `server\plugins` directory.
2. Add the project to `server\settings.gradle`
3. Add the project as a dependency to this project's `build.gradle` file using the `plugin` configuration.

[CanaryMod]: http://canarymod.net/
