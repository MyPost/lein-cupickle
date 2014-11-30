# lein-cucumis

lein-cucumis is a Leiningen plugin that uses the [Cucumis](https://github.com/MyPost/cucumis)
library to run a set of cucumber features against a set of step definitions.


## Usage

Run `lein cucumis`.

Cucumis is configured in your project under the `:cucumis` key.

For information about the options available to lein-cucumis, refer
the the Cucumis library.

The two main config items you may be interested in are:

* :feature-path (defaults to "features")
* :step-path    (defaults to :feature-path)

These can be supplied as simple bare-word pairs on the shell:

> lein cucumis step-path special-features


### Project Setup

Use this for project-level plugins:

Put `[lein-cucumis "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your project.clj.

Put `[cucumis "0.1.0-SNAPSHOT"]` into the `:dependencies` vector of your project.clj.


## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.


## TODO

Rename from Cucumis to something else. There seem to be enough projects called cucumis on github already...

Possibly

* digicumber
* ogorek
* shoecumber
* cuksey
* cumberparty
* beautyfruit - <https://www.flickr.com/photos/activesteve/5985975169/in/photolist-6zbaEG-6TVRiA-an4mSp-6HrPwi-aLPHpZ-8tHRKx-dtSDPo-dtSDAh-dtSDV5-7214Cu-a7XFSr-evSzvf-evPrKz-71W4Je-8v1eaS-HdPFv-8LdPU8-h8fDyH-cgsE61-abjaoH-6cybna-dtM6k2-dtSDv1-dtM6aT-dtM6Cv-dtM6v2-dtSDmq-dtSDxu-dtSDGU-dtM6h8-dtM6HR-71W4Qg-6o268F-A25Ua-72154b-7qvW8q-9csHFc-9MKumx-9MKtWz-9MNgxm-avnVEh-7ZZ8QB-b9Vu1B-71W4VR-dpfAJu-dpfrAM-dpfrQD-d38Rvs-d38Txm-4wMcJK>
* eyeslice
* roundeye
* greeneye
* fruiteye
* cuxi, cuxy
