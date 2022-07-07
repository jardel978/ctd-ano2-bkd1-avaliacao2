dbAdmin = db.getSiblingDB("admin");
dbAdmin.createUser({
  user: "test",
  pwd: "7890123",
  roles: [{ role: "userAdminAnyDatabase", db: "admin" }],
  mechanisms: ["SCRAM-SHA-1"],
});

dbAdmin.auth({
  user: "test",
  pwd: "7890123",
  mechanisms: ["SCRAM-SHA-1"],
  digestPassword: true,
});

db = new Mongo().getDB("avaliacao2_catalog");
db.createCollection('test', { capped: false });
db.test.insertOne({ "test": "test-catalog" });