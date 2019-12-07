(ns four-clojure-problems.for-103)

(def k-combinations
  (fn k-combinations [k S]
    (cond
      (<= k 0)        #{#{}}
      (< (count S) k) #{}
      :otherwise      (let [head      (first S)
                            remaining (rest S)]
                        (set (concat (k-combinations
                                      k remaining)
                                     (map #(conj % head)
                                          (k-combinations
                                           (dec k) remaining))))))))


(comment
  (k-combinations 3 #{0 1 2 3 4})

  (k-combinations 2 #{0 1 2})

  (k-combinations 1 #{2})
  )

(comment
  0
  1
  2
  3
  4

  0 1
  0 2
  0 3
  0 4
  1 2
  1 3
  1 4
  2 3
  2 4
  3 4

  0 1 2
  0 1 3
  0 1 4
  0 2 3
  0 2 4
  0 3 4
  1 2 3
  1 2 4
  1 3 4
  2 3 4

  0 1 2 3
  0 1 2 4
  0 1 3 4
  0 2 3 4
  1 2 3 4

  0 1 2 3 4
  )
