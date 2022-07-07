db.createUser(
        {
            user: "test",
            pwd: "7890123",
            roles: [
                {
                    role: "readWrite",
                    db: "avaliacao2_catalog"
                }
            ]
        }
);