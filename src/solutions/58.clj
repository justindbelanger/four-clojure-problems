(fn [& fns]
  (let [fns-rtl (reverse fns)]
    (fn [& args]
      
;;      (loop [result args composed fns-rtl]
;;        (if (empty? composed)
;;          result
;;          (recur 
;;           ((first composed) result) 
;;           (rest composed)))))))
