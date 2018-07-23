(ns four-clojure-problems.solutions.39)

(defn interleaven [s t]
  (if (not (or (empty? s) (empty? t)))
    (let [i (seq [(first s) (first t)]) u (rest s) v (rest t)]
      (if (or (empty? u) (empty? v))
        i
        (lazy-cat i (interleaven u v))))))

(def seq1 [1 2 3])

(def seq2 [:a :b :c])

(def seq3 [1 2])

(def seq4 [3 4 5 6])
