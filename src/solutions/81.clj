(fn [s t]
  (reduce 
   (fn [intersect s-member]
     (if (t s-member)
       (conj intersect s-member)
       intersect))
   #{} 
   s))
