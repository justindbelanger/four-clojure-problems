(fn [f s]
  (reduce 
   #(assoc 
      %1 
      (f %2) 
      (if
        (nil? (%1 (f %2)))
        [%2]
        (conj %1 %2)) ; if (f %2) is not a vector, create it. if it is, conj with it
   {}
   s))
