(fn [v s]
  (reduce 
   (fn ([interpd item]
     (conj interpd v item))
     ([] []))
   [(first s)]
   (rest s)))
