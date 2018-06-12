(fn [x y] 
  (loop [lst ()
         xSeq x
         ySeq y]
    (if (and (not-empty xSeq) (not-empty ySeq))
      (recur 
        (cons (first ySeq) (cons (first xSeq) lst)) (rest xSeq) (rest ySeq)
        )
      lst
    )
  )
)
