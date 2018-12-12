工程目录结构说明：
1. maven结构：
    change-pet-parent(父级)
        --change-pet-api(web api)
        --change-pet-client(feignClient对外公开接口)
        --change-pet-common(公用包-工具类、枚举等)
        --change-pet-entity(实体包-持久层实体po、业务实体dto、前端展示实体vo)
        --change-pet-dao(数据持久层，mybatis mapperXml)
        --change-pet-service(业务层)
