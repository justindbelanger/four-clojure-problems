(ns four-clojure-problems.solutions.31)

(def tests [{:value [1 1 2 1 1 1 3 3]
             :result '((1 1) (2) (1 1 1) (3 3))}
            {:value [:a :a :b :b :c]
             :result '((:a :a) (:b :b) (:c))}
            {:value [[1 2] [1 2] [3 4]]
             :result '(([1 2] [1 2]) ([3 4]))}])

(defn test-31 [f {:keys [value result]}]
  (= (f value)
     result))

(def pack (fn [s]
            (reverse (reduce (fn [p si]
                               (let [p1 (first p)
                                     dup (= (first p1)
                                            si)
                                     p1* (if dup
                                           (conj p1 si)
                                           (list si))
                                     p* (if dup
                                          (conj (rest p) p1*)
                                          (conj p p1*))]
                                 p*))
                             '()
                             s))))
