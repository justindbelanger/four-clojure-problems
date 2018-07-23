(ns four-clojure-problems.solutions.42)

(fn fact 
  ([n] (fact n 1))
  ([n accum] 
    (if (zero? n) accum
      (recur (dec n) (* accum n))
    )
  )
)
