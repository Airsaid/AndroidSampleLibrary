package com.cz.android.sample.component;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Created by cz
 * @date 2020-01-27 21:09
 * @email bingo110@126.com
 */
public class ComponentManager {
    /**
     * A singleton object
     */
    private static final ComponentManager componentManager=new ComponentManager();
    /**
     * The extra component list that will decorate every sample
     */
    private Set<ComponentContainer> componentContainerSet =new TreeSet<>(new Comparator<ComponentContainer>() {
        @Override
        public int compare(ComponentContainer c1, ComponentContainer c2) {
            int i = c2.getComponentPriority() - c1.getComponentPriority();
            return 0==i?-1:i;
        }
    });

    public static ComponentManager getInstance(){
        return componentManager;
    }

    private ComponentManager(){
    }

    /**
     * Add new componentContainer to list
     * @param componentContainer
     */
    public void addComponentContainer(ComponentContainer componentContainer){
        componentContainerSet.add(componentContainer);
    }

    /**
     * Relate companion component
     */
    public void relateCompanionComponent() {
        Set<ComponentContainer> componentContainerSet = componentManager.getComponentContainerSet();
        for(ComponentContainer componentContainer:componentContainerSet){
            if(componentContainer instanceof CompanionComponentContainer){
                CompanionComponentContainer companionComponentContainer = (CompanionComponentContainer) componentContainer;
                Class<CompanionComponentContainer>[] companionComponentClassArray = companionComponentContainer.getCompanionComponent();
                for(Class<CompanionComponentContainer> clazz:companionComponentClassArray){
                    for(ComponentContainer component:componentContainerSet){
                        if(clazz.isInstance(component)){
                            companionComponentContainer.addCompanionComponent((CompanionComponentContainer) component);
                        }
                    }
                }
            }
        }
    }

    public Set<ComponentContainer> getComponentContainerSet() {
        return componentContainerSet;
    }
}
