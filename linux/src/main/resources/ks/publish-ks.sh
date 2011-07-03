#/bin/sh
# This script lives at https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/ks/base-ks.cfg, but ks doesn't like https


cd /tmp
rm lovelock-white-rabbit-ks.cfg 2>/dev/null
wget https://raw.github.com/CheffPJ/jboss-as/linux_init/linux/src/main/resources/ks/lovelock-white-rabbit-ks.cfg
scp lovelock-white-rabbit-ks.cfg people.redhat.com:/home/remote/pmcdonou/public_html/src/ks/
