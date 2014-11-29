(ns leiningen.cucumis  (:require [cucumis.core        :as c]
                                 [leiningen.core.eval :as e])
  )

(defn cucumis
  "I don't do a lot."
  [project & args]
  ; (leiningen.core.main/info "Hi! - lein-cucumis")

  ; NOTE: Binding introduced so that cucumis can print using the lein tools,
  ;       As required by the lein plugin documentation.
  
  (let [{:keys [] :as arg-map} args]
     (binding [cucumis.core/cuc-print leiningen.core.main/info]
       (apply c/main (apply concat
                            (seq (merge (:cucumis project)
                                        (clojure.walk/keywordize-keys arg-map)))))))

  ; TODO: Decide if we should use this:
  ; (leiningen.core.eval/eval-in-project)
)


; Manual tests...
(comment
  (cucumis {:cucumis {:lol :haha}})
  (cucumis {:cucumis {:lol :haha}} :asdf :qwer)
)
