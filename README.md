# lein-cupickle

lein-cupickle is a Leiningen plugin that uses the [Cupickle](https://github.com/MyPost/cupickle)
library to run a set of cucumber features against a set of step definitions.

Stuck in your cubicle writing cucumber tests and clojure step-definitions?

Try lein-cupickle!


## Usage

Run `lein cupickle`.

Cupickle is configured in your project under the `:cupickle` key.

For information about the options available to lein-cupickle, refer
the the Cupickle library.

The two main config items you may be interested in are:

* :feature-path (defaults to "features")
* :step-path    (defaults to :feature-path)

These can be supplied as simple bare-word pairs on the shell:

> lein cupickle step-path special-features


### Project Setup

Use this for project-level plugins:

Put `[lein-cupickle "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your project.clj.

Put `[cupickle "0.1.0-SNAPSHOT"]` into the `:dependencies` vector of your project.clj.


## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


## TODO

* License
* Print dots without newlines for progress
