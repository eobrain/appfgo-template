(ns leiningen.new.appfgo
  (:require [leiningen.new.templates :refer [renderer year project-name
                                             ->files sanitize-ns name-to-path
                                             multi-segment]]
            [leiningen.core.main :as main]))

(defn appfgo
  "Generate a basic Funcgo application project."

  [name]
  (let [render (renderer "appfgo")
        main-ns (multi-segment (sanitize-ns name))
        data {:name name
              :namespace main-ns
              :raw-name name
              :year (year)
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' appfgo project.")
    (->files data
             [".gitignore" (render ".gitignore" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["src/{{sanitized}}/core.go" (render "core.go" data)]
             ["test/{{sanitized}}/core_test.go" (render "core_test.go" data)] )))
