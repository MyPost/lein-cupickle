# lein-cucumis

lein-cucumis is a Leiningen plugin that uses the [Cucumis](Link-Pending)
library to run a set of cucumber features against a set of step definitions.


## Usage

Run `lein cucumis`.

Cucumis is configured in your project under the `:cucumis` key.

For information about the options available to lein-cucumis, refer
the the Cucumis library.

The two main config items you may be interested in are:

* :feature-path (defaults to "features")
* :step-path    (defaults to :feature-path)


### Project Setup

Use this for project-level plugins:

Put `[lein-cucumis "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your project.clj.

Put `[cucumis "0.1.0-SNAPSHOT"]` into the `:dependencies` vector of your project.clj.


## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
