(ns four-clojure-problems.for-128-test
  (:require [clojure.test :refer [deftest testing is]]
            [four-clojure-problems.for-128 :as sut]))

(deftest recognize-playing-card-test
  (is (= {:suit :diamond :rank 10} (sut/recognize-playing-card "DQ")))
  (is (= {:suit :heart :rank 3} (sut/recognize-playing-card "H5")))
  (is (= (range 13)
         (map (comp :rank sut/recognize-playing-card str)
              '[S2 S3 S4 S5 S6 S7
                S8 S9 ST SJ SQ SK SA]))))
