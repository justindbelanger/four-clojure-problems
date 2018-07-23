(ns four-clojure-problems.solutions.99)

(def product-digits (fn [x y]
                      (let [separate-digits-fn (fn [i]
                                                 {:pre [(>= i 0)]}
                                                 (loop [i* i
                                                        digits '()]
                                                   (let [q (quot i* 10)
                                                         r (rem i* 10)
                                                         digits* (conj digits r)]
                                                     (if (= q 0)
                                                       digits*
                                                       (recur q digits*)))))]
                        (separate-digits-fn (* x y)))))

(def examples [{:input [1 1]
                :result [1]}
               {:input [99 9]
                :result [8 9 1]}
               {:input [999 99]
                :result [9 8 9 0 1]}])
