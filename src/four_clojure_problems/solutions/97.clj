(ns four-clojure-problems.solutions.97)

(def sum-as-pairs (fn sum-fn [[i & others]]
                    (let [j (first others)]
                      (if (and i j)
                        (let [summed (+ i j)
                              more (if others
                                     (lazy-seq (sum-fn others))
                                     '())]
                          (cons summed more))
                        '()))))

(def pascal-triangle (fn pt [n]
                       (if (= 1 n)
                         '(1)
                         (concat [1]
                                 (sum-as-pairs (pt (- n 1)))
                                 [1]))))

(def solution (fn pt [n]
                (let [sum-fn (fn sum-fn [[i & others]]
                               (let [j (first others)]
                                 (if (and i j)
                                   (let [summed (+ i j)
                                         more (if others
                                                (lazy-seq (sum-fn others))
                                                '())]
                                     (cons summed more))
                                   '())))]
                  (if (= 1 n)
                    '(1)
                    (concat [1]
                            (sum-fn (pt (- n 1)))
                            [1])))))
