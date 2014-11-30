(ns leiningen.cucumis  (:require [cucumis.core        :as c]
                                 [leiningen.core.eval :as e]
                                 [leiningen.core.main :as l])
  )

(defn run-cucumis [project {:keys [] :as arg-map}]
  ;
  ; NOTE: Binding introduced so that cucumis can print using the lein tools,
  ;       As required by the lein plugin documentation.
  ;
  (binding [c/cuc-print leiningen.core.main/info]
    (apply c/main (apply concat
                         (seq (merge (:cucumis project)
                                     (clojure.walk/keywordize-keys arg-map)))))))

(defn cucumis
  "
  Kicks off the cucumber test-run.

  Arguments are key-value pairs determined by the cucumis library.
  "
  [project & args]

  (let [result (run-cucumis project args)]
    (if true
      (l/abort "Some cucumis tests failed.")))

  ; TODO: Decide if we should use this:
  ; (leiningen.core.eval/eval-in-project)
)


; Manual tests...
(comment
  (cucumis {:cucumis {:lol :haha}})
  (cucumis {:cucumis {:lol :haha}} :asdf :qwer)
)
