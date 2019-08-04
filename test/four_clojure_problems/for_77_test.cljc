(ns four-clojure-problems.for-77-test
  (:require [four-clojure-problems.for-77 :as for-77]
            #?(:clj [clojure.test :refer [are deftest is testing]]
               :cljs [cljs.test :refer-macros [are testing deftest is]])))

(deftest find-anagrams-test
  (is (= #{#{"meat" "team" "mate"}}
         (for-77/find-anagrams ["meat" "mat" "team" "mate" "eat"])))
  (is (= #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}}
         (for-77/find-anagrams ["veer" "lake" "item" "kale" "mite" "ever"]))))
