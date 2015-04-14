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

Running the Application
--------------

At present, the `run` target of the Gradle Application plugin will not work.  To run the server, run `gradlew install`.  This creates a distribution in `build/install/appMain`.  From `build/install/appMain` run `bin/appMain`.  The server will start, read the eula.txt in the directory and look for plugins in the `plugins` sub-directory.  

**Note:** You must be in the "root" (e.g. `build/install/appMain`) directory for the app to run properly.  


[CanaryMod]: http://canarymod.net/
