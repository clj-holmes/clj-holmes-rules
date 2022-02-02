(ns vulnerable.clj
  (:import [javax.crypto Cipher]))

(defn encrypt-vulnerable [data public-key]
  (let [rsa (Cipher/getInstance "RSA/ECB/PKCS1Padding")]
    (.init rsa Cipher/ENCRYPT_MODE public-key)
    (.doFinal rsa data)))

(defn encrypt-not-vulnerable [data des-key]
  (let [cipher (Cipher/getInstance "DESede/CBC/NoPadding")]
    (.init cipher Cipher/ENCRYPT_MODE (SecretKeySpec. des-key "DESede") (IvParameterSpec. des-key 0 8))
    (.doFinal cipher data)))
