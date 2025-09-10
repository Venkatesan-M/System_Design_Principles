# CAP Theorem - High Level Design Revision Notes

## What is CAP Theorem?
**CAP Theorem** states that in a distributed system, you can only guarantee **2 out of 3** properties simultaneously:

## The 3 Properties

### **C - Consistency** 🔄
- All nodes see the same data at the same time
- Every read gets the most recent write
- **Example**: Banking system - all ATMs show same account balance

### **A - Availability** 🟢  
- System remains operational and responsive
- Every request gets a response (success or failure)
- **Example**: Social media feed - always loads even if slightly outdated

### **P - Partition Tolerance** 🌐
- System continues to operate despite network failures
- Can handle communication breakdowns between nodes
- **Example**: System works even if some servers can't talk to each other

## CAP Trade-offs

### **CP Systems** (Choose Consistency + Partition Tolerance)
- **Sacrifice**: Availability
- **When**: Network partition → System becomes unavailable
- **Examples**: MongoDB, Redis, HBase
- **Use Case**: Financial systems, inventory management

### **AP Systems** (Choose Availability + Partition Tolerance)  
- **Sacrifice**: Consistency
- **When**: Network partition → System stays available but may serve stale data
- **Examples**: Cassandra, DynamoDB, CouchDB
- **Use Case**: Social media, content delivery, analytics

### **CA Systems** (Choose Consistency + Availability)
- **Sacrifice**: Partition Tolerance
- **Reality**: Not practical in distributed systems
- **Examples**: Traditional RDBMS (MySQL, PostgreSQL) in single-node setup
- **Use Case**: Single data center with reliable network

## Real-World Examples

| System | Type | Trade-off | Use Case |
|--------|------|-----------|----------|
| **MongoDB** | CP | May become unavailable during partitions | Financial transactions |
| **Cassandra** | AP | Eventually consistent, always available | User profiles, logs |
| **MySQL** | CA | Assumes no network partitions | Single server applications |
| **DynamoDB** | AP | Tunable consistency, high availability | Gaming, IoT |

## Key Insights
- **Network partitions are inevitable** in distributed systems
- **CA systems don't exist** in truly distributed environments  
- **Choose based on business requirements**:
  - Need accurate data? → CP
  - Need system always running? → AP
- **Eventual consistency** is often acceptable for AP systems

## Interview Points
- CAP is about **trade-offs during network partitions**
- **P is not optional** in distributed systems
- Real choice is between **C or A** during partitions
- Different parts of system can make different CAP choices
- **PACELC theorem** extends CAP (Partition tolerance, Availability, Consistency, Else Latency, Consistency)