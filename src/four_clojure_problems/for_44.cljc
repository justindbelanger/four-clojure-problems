(ns four-clojure-problems.for-44)

(defn rotate-sequence
  "Rotates the provided sequence `s` by the `amount`.
  If the amount is positive, rotates from the beginning toward the end.
  If the amount is negative, rotates from the end toward the beginning."
  [amount s]
  (let [length  (count s)
        index   (mod amount length)
        split   (split-at index s)
        rotated (->> split
                     reverse
                     (mapcat identity))]
    rotated))
