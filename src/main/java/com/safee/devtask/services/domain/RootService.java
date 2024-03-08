package com.safee.devtask.services.domain;

import com.google.common.reflect.TypeToken;
import com.safee.devtask.entities.BaseEntity;
import com.safee.devtask.mappers.RootMapper;
import com.safee.devtask.repositories.RootRepo;
import com.safee.devtask.util.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public interface RootService<T, ID> {


    default Optional<T> getObjectById(
            ID id) {

        RootRepo<Object, ID> repo = getRepoObject();
        RootMapper<Object, T> mapper = getMapperObject();

        return Optional.ofNullable(mapper.objToDto(repo.findById(id)
                                                       .orElse(null)));
    }

    default Page<T> getAllObjects(Integer pageNumber, Integer pageSize) {
        RootRepo<Object, ID> repo = getRepoObject();
        RootMapper<Object, T> mapper = getMapperObject();

        PageRequest pageRequest =getPageRequest(pageNumber,pageSize);

        return repo.findAll(pageRequest)
                   .map(mapper::objToDto);
    }

    default T saveNewObject(
            T object) {
        RootRepo<Object, ID> repo = getRepoObject();
        RootMapper<Object, T> mapper = getMapperObject();

        return mapper.objToDto(repo.save(mapper.dtoToObj(object)));
    }

    default Optional<T> updateObjectById(ID id,
                                         T object) {
        RootRepo<Object, ID> repo = getRepoObject();
        RootMapper<Object, T> mapper = getMapperObject();

        AtomicReference<Optional<T>> atomicReference = new AtomicReference<>();


        repo.findById(id)
            .ifPresentOrElse(foundObject -> {
                BaseEntity baseEntity= (BaseEntity) mapper.dtoToObj(object);
                baseEntity.setId((Long) id);

                var savedObj= repo.save(baseEntity);
                atomicReference.set(Optional.of(mapper.objToDto(savedObj)));
            }, () -> atomicReference.set(Optional.empty()));

        return atomicReference.get();
    }

    default Boolean deleteObjectById(
            ID id) {
        RootRepo<Object, ID> repo = getRepoObject();

        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }


    default String getEntityName() {
        TypeToken<T> typeToken = new TypeToken<>(getClass()) {
        };
        Class<T> type = (Class<T>) typeToken.getRawType();

        String entityName = type.getName()
                                .replace("models", "(??)");
        entityName = entityName.substring(0, entityName.length() - 3);

        return entityName;
    }


    default RootMapper<Object, T> getMapperObject() {
        String changedPackageName = getEntityName().replace("(??)", "mappers");
        String className = changedPackageName + "Mapper";
        ApplicationContext context = ApplicationContextProvider.getApplicationContext();

        try {
            return (RootMapper<Object, T>) context.getBean(Class.forName(className));
        } catch (Exception exception) {
            System.out.println("No mapper found for entity " + className);
            return null;
        }
    }

    default RootRepo<Object, ID> getRepoObject() {

        String changedPackageName = getEntityName().replace("(??)", "repositories");
        String className = changedPackageName + "Repo";

        ApplicationContext context = ApplicationContextProvider.getApplicationContext();

        try {
            return (RootRepo<Object, ID>) context.getBean(Class.forName(className));
        } catch (Exception exception) {
            System.out.println("No JpaRepository found for entity " + className);
            return null;

        }
    }

   default PageRequest getPageRequest(Integer pageNumber, Integer pageSize){
        pageNumber = pageNumber == null || pageNumber > 1000 ? 0 : pageNumber;
        pageSize = pageSize == null ? 10 : pageSize;
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        return pageRequest;
    }

}
