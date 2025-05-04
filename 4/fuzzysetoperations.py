# ---------- Fuzzy Set Operations ----------

def fuzzy_union(A, B):
    return {x: max(A.get(x, 0), B.get(x, 0)) for x in set(A) | set(B)}

def fuzzy_intersection(A, B):
    return {x: min(A.get(x, 0), B.get(x, 0)) for x in set(A) & set(B)}

def fuzzy_difference(A, B):
    return {x: min(A.get(x, 0), 1 - B.get(x, 0)) for x in A}

def fuzzy_complement(A):
    return {x: 1 - A[x] for x in A}

# ---------- Fuzzy Relations (Cartesian Product) ----------

def cartesian_product(A, B):
    return {(x, y): min(A[x], B[y]) for x in A for y in B}

# ---------- Max-Min Composition ----------

def max_min_composition(R1, R2):
    result = {}
    xs = {x for x, _ in R1}
    zs = {z for _, z in R2}
    ys_R1 = {y for _, y in R1}
    ys_R2 = {y for y, _ in R2}
    common_ys = ys_R1 & ys_R2

    for x in xs:
        for z in zs:
            mins = [min(R1.get((x, y), 0), R2.get((y, z), 0)) for y in common_ys]
            result[(x, z)] = max(mins) if mins else 0
    return result

# # ---------- Example Fuzzy Sets ----------


# def input_fuzzy_set(set_name):
#     fuzzy_set = {}
#     n = int(input(f"Enter number of elements in fuzzy set {set_name}: "))
#     for i in range(n):
#         key = input(f"Enter label for element {i+1} of {set_name} (e.g., x1): ")
#         while True:
#             try:
#                 value = float(input(f"Enter membership value for {key} (between 0 and 1): "))
#                 if 0 <= value <= 1:
#                     break
#                 else:
#                     print("Value must be between 0 and 1.")
#             except ValueError:
#                 print("Invalid input. Please enter a numeric value.")
#         fuzzy_set[key] = value
#     return fuzzy_set

# A = input_fuzzy_set("A")
# B = input_fuzzy_set("B")


A = {'x1': 0.2, 'x2': 0.7, 'x3': 1.0}
B = {'x1': 0.6, 'x2': 0.4, 'x3': 0.9}

# ---------- Run Operations ----------

print("Fuzzy Set A:", A)
print("Fuzzy Set B:", B)

print("\n--- Fuzzy Set Operations ---")
print("Union (A ∪ B):", fuzzy_union(A, B))
print("Intersection (A ∩ B):", fuzzy_intersection(A, B))
print("Difference (A - B):", fuzzy_difference(A, B))
print("Complement of A:", fuzzy_complement(A))

# ---------- Fuzzy Relations ----------

R1 = cartesian_product(A, B)
R2 = cartesian_product(B, A)

print("\n--- Fuzzy Cartesian Product ---")
print("Fuzzy Relation R1 (A × B):")
for key, val in R1.items():
    print(f"{key}: {val}")

print("\nFuzzy Relation R2 (B × A):")
for key, val in R2.items():
    print(f"{key}: {val}")

# ---------- Max-Min Composition ----------

composed = max_min_composition(R1, R2)

print("\n--- Max-Min Composition of R1 and R2 ---")
for key, val in composed.items():
    print(f"{key}: {val}")


