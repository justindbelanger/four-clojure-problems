(ns four-clojure-problems.for-103)

#_(defn indices
  [k length]
  (let []))

#_(defn k-combinations
  [k s]
  )

(def (fn  f [k S]
  (cond
    (<= k 0)        #{#{}}
    (< (count S) k) #{}
    :otherwise      (let [head      (first S)
                          remaining (rest S)]
                      (set (concat (f k remaining)
                                   (map #(conj % head)
                                        (f (dec k) remaining))))))))
(defn f [k S]
  (cond
    (<= k 0)        #{#{}}
    (< (count S) k) #{}
    :otherwise      (let [head      (first S)
                          remaining (rest S)]
                      (set (concat (f k remaining)
                                   (map #(conj % head)
                                        (f (dec k) remaining)))))))

(comment
  (f 3 #{0 1 2 3 4})

  (f 2 #{0 1 2})

  (f 1 #{2})
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
