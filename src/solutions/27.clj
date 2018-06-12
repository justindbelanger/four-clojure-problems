;(fn [seq]
;  (loop [theSeq seq] 
;    (if (or (empty? theSeq) (= 1 (count theSeq))) 
;      true 
;      (and (= (first theSeq) (last theSeq)) (recur (take (dec (count theSeq)) (rest theSeq))))
;    )
;  )
;)
(fn [mySeq]
  (if (or (not (seq? mySeq)) (empty? mySeq)) true
    (if (not (= (first mySeq) (last mySeq))) false 
      (recur (rest (butlast mySeq)))
    )
  )
)
