(ns four-clojure-problems.for-120)

#_(def separate-digits-alt (fn [i]
                           (map #(int (bigdec (str %))) (seq (str i)))))

(def separate-digits (fn [i]
                       {:pre [(>= i 0)]}
                       (loop [i*     i
                              digits '()]
                         (let [q       (quot i* 10)
                               r       (rem i* 10)
                               digits* (conj digits r)]
                           (if (= q 0)
                             digits*
                             (recur q digits*))))))

(def less-than-sum-of-squares
  (fn [ints]
    (let [seperate-digits-fn (fn [i]
                               {:pre [(>= i 0)]}
                               (loop [i*     i
                                      digits '()]
                                 (let [q       (quot i* 10)
                                       r       (rem i* 10)
                                       digits* (conj digits r)]
                                   (if (= q 0)
                                     digits*
                                     (recur q digits*)))))]
      (count (filter (fn [i]
                       (< i (reduce +
                                    0
                                    (map (fn [d] (* d d))
                                         (seperate-digits-fn i)))))
                     ints)))))
