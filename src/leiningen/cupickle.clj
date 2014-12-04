(ns leiningen.cupickle  (:require [leiningen.core.eval      :as e]
                                  [leiningen.core.project   :as p]
                                  [leiningen.core.main      :as l]))

(defn run-cupickle [config {:keys [] :as arg-map}]
  `(let [result# (apply cupickle.core/main
                       (apply concat
                              (seq (merge ~config
                                          (clojure.walk/keywordize-keys ~arg-map)))))
         errors# (not (empty? (filter #(= :error (:type %)) result#))) ]

     (if errors#
       ; TODO: Find out if there is a better way to generate an error... 
       (System/exit 1)
       (System/exit 0)
       )))

(defn is-help [arg]
  (or (= arg "help")
      (= arg "--help")
      (= arg "-h")))

(defn asking-for-help? [args]
  (< 0 (count (filter is-help args))))

(defn cupickle
  "Run cucumber tests."
  [project & args]
  (let [profile {:dependencies [['au.com.auspost/cupickle "0.2.0"] ]}
        project (p/merge-profiles project [profile])
        config  (:cupickle project)
        ]
    (e/eval-in-project project
                       (if (asking-for-help? args)
                         '(cupickle.core/help)
                         (run-cupickle config args))

                       '(require 'cupickle.core))
    (l/exit)))
