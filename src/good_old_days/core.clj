(ns good-old-days.core)

(defn car
  "Contents of address register"
  [exp]
  (first exp)
  )

(defn cdr
  "Contents of decrement register"
  [exp]
  (rest exp)
  )

(defn cadr
  "The car of the cdr"
  [exp]
  (car (cdr exp))
  )
