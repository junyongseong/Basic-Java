"use client"

import Image from "next/image";
import styles from "./page.module.css";
import { useState } from "react";

export default function Home() {
  let title = "SIST";
  let title2 = "SIST2";
  const [sub, setSub] = useState("Michale")
  return (
    <div className={styles.page}>
      <h1 className="title">{title}</h1>
      <h1 className={styles.redcolor}>{title2}</h1>
      <h2>{sub}</h2>
    </div>
  );
}
