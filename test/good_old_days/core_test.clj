(ns good-old-days.core-test
  (:use midje.sweet)
  (:require [good-old-days.core :refer :all]))


(def hello '("Chris", "Mark", "Stacy"))
(def hello-with-sublist '(("Sarah", ("Chris")), "Mark", "Stacy"))
(def deeply-nested '(((((2))))))


(facts
 "car facts"
 (fact "car is the first in the list"
       (car '(1 2 3)) => '1)

 (fact "car isn't the second item in the list"
       (car '(1 2 3)) =not=> '2)

 (fact "car can handle a sublist"
       (car hello-with-sublist) => '("Sarah", ("Chris")))

 (fact "car can handle a sublist"
       (car (car hello-with-sublist)) => '"Sarah")

 (fact "car can handle deep nesting with ease "
       (car (car (car (car (car  deeply-nested))))) => '2)
 )

(facts
 "cdr facts"
 (fact "cdr is not the first in the list"
       (cdr '(1 2 3)) =not=> '1)

 (fact "cdr is the rest of the list"
       (cdr '(1 2 3)) => '(2 3))

 (fact "cdr can handle a sublist"
       (cdr hello-with-sublist) => '("Mark", "Stacy"))
 )

(facts
 "cadr facts"
 (fact "cadr is the car of the cdr"
       (cadr hello) => "Mark")
 (fact "cadr is the car of the cdr"
       (cadr hello-with-sublist) => "Mark")
 )
