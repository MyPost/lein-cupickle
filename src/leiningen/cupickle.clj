(ns leiningen.cupickle  (:require [cupickle.core            :as c]
                                  [leiningen.core.eval      :as e]
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
       (System/exit 1))))

(defn is-help [arg]
  (or (= arg "help")
      (= arg "--help")
      (= arg "-h")))

(defn asking-for-help? [args]
  (< 0 (count (filter is-help args))))

(defn cupickle
  "Run cucumber tests."
  [project & args]

  (if (asking-for-help? args)
    (c/help)
    (let [profile {:dependencies [['au.com.auspost/cupickle "0.2.0"] ]}
          project (p/merge-profiles project [profile])
          config  (:cupickle project)
          errors? (e/eval-in-project project
                                     (run-cupickle config args)
                                     '(do (require 'cupickle.core)))])))
