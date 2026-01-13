# 🅿️ Simple Parking Lot System (Humanized Design)

This document explains a **very simple Parking Lot system** using **clean thinking** and **basic SOLID ideas**, without over-engineering.

The goal is clarity, not complexity.

---

## 🧠 Real-World Flow (How Humans Think)

What actually happens in a parking lot:

1. A vehicle arrives
2. System checks if **any parking spot is free**
3. If yes → vehicle is parked and a **ticket is generated**
4. Vehicle stays for some time
5. Vehicle exits
6. Driver **pays using Cash / Card / GPay**
7. Parking spot becomes free again

That’s it.

No extra rules. No assumptions.

---

## 🧩 Core Components

We only model what exists in real life.

### 1️⃣ Vehicle
Represents the vehicle entering the parking lot.

Responsibility:
- Hold vehicle number

---

### 2️⃣ Parking Spot
Represents a single parking space.

Responsibility:
- Knows whether it is **free or occupied**
- Can be occupied or released

Each spot is independent.

---

### 3️⃣ Ticket
Given to the driver when parking.

Responsibility:
- Stores:
  - Parking spot number
  - Entry time

Used later to calculate parking duration.

---

### 4️⃣ Payment (Interface)
Represents **how payment is made**.

Why interface?
- Payment methods can change
- Parking lot should not care *how* money is paid

Payment types:
- Cash
- Card
- GPay

Each payment method implements the same `pay(amount)` behavior.

---

### 5️⃣ Parking Lot
Acts like a **manager**, not a worker.

Responsibility:
- Find an empty parking spot
- Assign the spot
- Generate ticket
- On exit:
  - Calculate parking duration
  - Ask payment system to collect money
  - Free the parking spot

Parking lot does **not** handle payment logic itself.

---

## 🔄 Parking Flow Explained

### 🟢 Entry
1. Vehicle arrives
2. Parking lot scans for a free spot
3. First free spot is assigned
4. Ticket is created with:
   - Spot ID
   - Entry time

---

### 🔴 Exit
1. Driver provides ticket
2. Parking lot:
   - Calculates parked duration
   - Computes amount (simple rule)
3. Payment is done using:
   - Cash / Card / GPay
4. Spot is released

---

## 💳 Payment Design (Very Simple)

Payment is **pluggable**.

Examples:
- `CashPayment`
- `CardPayment`
- `GPayPayment`

All follow the same rule:
- Accept amount
- Print confirmation

Parking lot only knows:
> “Someone will pay. I don’t care how.”

---

## 🧠 SOLID Principles (Naturally Applied)

### ✅ Single Responsibility
Each class has **one clear job**:

| Class | Responsibility |
|------|---------------|
| Vehicle | Identify vehicle |
| ParkingSpot | Track free/occupied |
| Ticket | Store entry info |
| Payment | Handle payment |
| ParkingLot | Coordinate flow |

---

### ✅ Open / Closed
New payment methods can be added **without changing parking logic**.

Example:
- Add `PhonePePayment`
- No changes in ParkingLot

---

### ✅ Liskov Substitution
Any payment method can replace another without breaking the system.

Cash, Card, GPay → all behave the same from ParkingLot’s view.

---

### ✅ Interface Segregation
No large interfaces.
Payment interface contains only:
- `pay(amount)`

---

### ✅ Dependency Inversion
Parking lot depends on:
- `Payment` interface

Not on:
- Cash / Card / GPay concrete implementations

---

## 🎯 Why This Design Works Well

- Easy to explain on whiteboard
- No enums, factories, or patterns spam
- Mirrors real-life behavior
- Extendable but not complicated
- Perfect for LLD interviews

---

## 🧾 Summary

This parking lot design focuses on:
- Simplicity
- Readability
- Real-world mapping
- Clean separation of responsibilities

It solves the problem **without overthinking it**.

> Simple systems are easier to explain, maintain, and extend.
