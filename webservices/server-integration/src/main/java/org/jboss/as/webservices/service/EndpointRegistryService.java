/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2010, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.webservices.service;

import org.jboss.as.webservices.util.WSServices;
import org.jboss.logging.Logger;
import org.jboss.msc.service.Service;
import org.jboss.msc.service.ServiceBuilder;
import org.jboss.msc.service.ServiceBuilder.DependencyType;
import org.jboss.msc.service.ServiceController;
import org.jboss.msc.service.ServiceController.Mode;
import org.jboss.msc.service.ServiceListener;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.ServiceTarget;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;
import org.jboss.msc.value.InjectedValue;
import org.jboss.ws.common.management.DefaultEndpointRegistry;
import org.jboss.ws.common.management.ManagedEndpointRegistry;
import org.jboss.wsf.spi.management.EndpointRegistry;

import javax.management.MBeanServer;

/**
 * The service for the endpoint registry
 *
 * @author alessio.soldano@jboss.com
 * @author <a href="mailto:ropalka@redhat.com">Richard Opalka</a>
 */
public final class EndpointRegistryService implements Service<EndpointRegistry> {

    private static final Logger log = Logger.getLogger(EndpointRegistryService.class);
    private static final ServiceName MBEAN_SERVER_NAME = ServiceName.JBOSS.append("mbean", "server");
    private static final EndpointRegistryService INSTANCE = new EndpointRegistryService();

    private volatile EndpointRegistry registry;
    private final InjectedValue<MBeanServer> injectedMBeanServer = new InjectedValue<MBeanServer>();

    private EndpointRegistryService() {
        // forbidden inheritance
    }

    @Override
    public EndpointRegistry getValue() {
        return registry;
    }

    @Override
    public void start(final StartContext context) throws StartException {
        log.tracef("Starting %s", EndpointRegistryService.class.getName());
        if (injectedMBeanServer.getValue() != null) {
            final ManagedEndpointRegistry managedEndpointRegistry = new ManagedEndpointRegistry();
            managedEndpointRegistry.setMbeanServer(injectedMBeanServer.getValue());
            registry = managedEndpointRegistry;
        } else {
            registry = new DefaultEndpointRegistry();
        }
    }

    @Override
    public void stop(final StopContext context) {
        log.tracef("Stopping %s", EndpointRegistryService.class.getName());
    }

    private InjectedValue<MBeanServer> getMBeanServerInjector() {
        return injectedMBeanServer;
    }

    public static ServiceController<?> install(final ServiceTarget serviceTarget, final ServiceListener<Object>... listeners) {
        final ServiceBuilder<EndpointRegistry> builder = serviceTarget.addService(WSServices.REGISTRY_SERVICE, INSTANCE);
        builder.addDependency(DependencyType.REQUIRED, MBEAN_SERVER_NAME, MBeanServer.class, INSTANCE.getMBeanServerInjector());
        builder.addListener(listeners);
        builder.setInitialMode(Mode.ACTIVE);
        return builder.install();
    }

}
