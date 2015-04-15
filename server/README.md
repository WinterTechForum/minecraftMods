Minecraft Server and Server Plugins
=============

This project is a set of plugins based on [CanaryMod] and an app framework to run a Minecraft server with the plugins installed. The `appMain` project contains the app framework.

Creating a Plugin
------------

To add a plugin, do the following:

1. Create the plugin project in the `plugins` directory.
2. Add the project to `settings.gradle` in this directory.
3. Add the project as a dependency to `appMain/build.gradle` using the `plugin` configuration.

Running the Minecraft Server
------------

See the `appMain` project to run the Minecraft server.

[CanaryMod]: http://canarymod.net/
