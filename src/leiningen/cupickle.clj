(ns leiningen.cupickle  (:require [cupickle.core       :as c]
                                  [leiningen.core.eval :as e]
                                  [leiningen.core.main :as l])
  )

(defn run-cupickle [project {:keys [] :as arg-map}]

  (apply c/main (apply concat
                       (seq (merge (:cupickle project)
                                   (clojure.walk/keywordize-keys arg-map))))))

(defn is-help [arg]
  (or (= arg "help")
      (= arg "--help")
      (= arg "-h")))

(defn asking-for-help? [args]
  (< 0 (count (filter is-help args))))

(defn cupickle
  "Run cucumber tests."
  [project & args]

  ; NOTE: Binding introduced so that cupickle can print using the lein tools,
  ;       As required by the lein plugin documentation.
  ;
  (binding [c/cuc-print leiningen.core.main/info]
    (if (asking-for-help? args)
      (c/help)
      (let [results (run-cupickle project args)
            errors  (filter #(= :error (:type %)) results)]
        (if-not (empty? errors)
          (l/abort "Some cupickle tests failed.")))))



  ; TODO: Decide if we should use this:
  ; (leiningen.core.eval/eval-in-project)
)


; Manual tests...
(comment
  (cupickle {:cupickle {:lol :haha}})
  (cupickle {:cupickle {:lol :haha}} :asdf :qwer)
)
