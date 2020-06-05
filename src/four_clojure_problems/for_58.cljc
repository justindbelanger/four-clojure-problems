(ns four-clojure-problems.for-58)

(def compo
  (fn [& fns]
    (fn [& args]
      (let [fns' (reverse fns)
            f    (first fns')
            fx   (apply f args)]
        (reduce (fn [state f]
                  (f state))
                fx
                (rest fns'))))))
