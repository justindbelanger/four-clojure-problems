;(fn [data index]
;  ((reduce 
;    (fn [x y]
;      (conj x y)
;    ) [] data) index
;  )
;)
(fn [data index]
  ((vec data) index)
)
