Frequency Map: {16=2, 2=2, 4=2}
Max value: 16
Ones before adjustment: 0
Ones after adjustment: -1
Map after removing 1: {16=2, 2=2, 4=2}

Starting chain from: 16
  Visiting 16, frequency = 2
    Count incremented to 1
  Updating res with count - 1 = 0
Current res = 0

Starting chain from: 2
  Visiting 2, frequency = 2
    Count incremented to 1
  Visiting 4, frequency = 2
    Count incremented to 2
  Visiting 16, frequency = 2
    Count incremented to 3
  Updating res with count - 1 = 2
Current res = 2

Starting chain from: 4
  Visiting 4, frequency = 2
    Count incremented to 1
  Visiting 16, frequency = 2
    Count incremented to 2
  Updating res with count - 1 = 1
Current res = 2
Final res = 2
Final ones = -1
Answer = 5