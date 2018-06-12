(fn [firstVal & restVals]
  (reduce (fn [x y] (if (>= x y) x y)) firstVal restVals)
)
