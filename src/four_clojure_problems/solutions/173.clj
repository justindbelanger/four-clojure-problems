(ns four-clojure-problems.solutions.173)

(= 3
   (let [[f a] [+ (range 3)]] (apply f a))
   (let [[[f a] b] [[+ 1] 2]] (f a b))
   (let [[f a] [inc 2]] (f a)))
