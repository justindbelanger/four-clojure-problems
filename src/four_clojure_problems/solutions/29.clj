(fn [text] 
  (clojure.string/join "" (re-seq #"[A-Z]" text))
)
